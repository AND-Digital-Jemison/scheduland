resource "aws_elastic_beanstalk_application" "scheduland-app" {
  name = "scheduland-app"
  description = "Scheduling App"
}

resource "aws_elastic_beanstalk_application_version" "scheduland-app-version"{
  application = aws_elastic_beanstalk_application.scheduland-app.name
  bucket = aws_s3_bucket.scheduland-code-bucket.id
  key = aws_s3_bucket_object.scheduland-code-bucket-object.id
  name = "scheduland-1.0.0"
}

resource "aws_s3_bucket" "scheduland-code-bucket" {
  bucket = "scheduland-prod"
  acl = "private"
  force_destroy= "true"
}

resource "aws_s3_bucket_object" "scheduland-code-bucket-object" {
  bucket = aws_s3_bucket.scheduland-code-bucket.id
  key = "beanstalk/scheduland"
  source = "../server/build/libs/scheduland-0.0.1-SNAPSHOT.jar"
}


resource "aws_elastic_beanstalk_environment" "scheduland-app-env" {
  name                = "scheduland-app-env"
  application         = aws_elastic_beanstalk_application.scheduland-app.name
  solution_stack_name = "64bit Amazon Linux 2 v3.4.1 running Corretto 17"
  version_label = aws_elastic_beanstalk_application_version.scheduland-app-version.name

  setting {
    name = "SERVER_PORT"
    namespace = "aws:elasticbeanstalk:application:environment"
    value = "5000"
  }

  setting {
    namespace = "aws:ec2:instances"
    name = "InstanceTypes"
    value = "t2.micro"
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "IamInstanceProfile"
    value     =  "aws-elasticbeanstalk-ec2-role"
  }
}