resource "aws_elastic_beanstalk_application" "schedulandtf" {
  name = "scheduland"
  description = "Scheduling App"
}

resource "aws_elastic_beanstalk_application_version" "schedulandtf_version"{
  application = aws_elastic_beanstalk_application.schedulandtf.name
  bucket = aws_s3_bucket.scheduland_code_bucket.id
  key = aws_s3_bucket_object.scheduland_code_bucket_object.id
  name = "scheduland-1.0.0"
}

resource "aws_s3_bucket" "scheduland_code_bucket" {
  bucket = "scheduland-prod"
  acl = "private"
}

resource "aws_s3_bucket_object" "scheduland_code_bucket_object" {
  bucket = aws_s3_bucket.scheduland_code_bucket.id
  key = "beanstalk/scheduland"
  source = "../server/build/libs/scheduland-0.0.1-SNAPSHOT.jar"
}


resource "aws_elastic_beanstalk_environment" "schedulandtfenv" {
  name                = "schedulandtf"
  application         = aws_elastic_beanstalk_application.schedulandtf.name
  solution_stack_name = "64bit Amazon Linux 2 v3.4.1 running Corretto 17"
  version_label = aws_elastic_beanstalk_application_version.schedulandtf_version.name

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