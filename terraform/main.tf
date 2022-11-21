resource "aws_elastic_beanstalk_application" "schedulandtf" {
  name = "scheduland"
  description = "Scheduling App"
}

resource "aws_s3_bucket" "scheduland_code_bucket" {
  bucket = "scheduland-prod"
  acl = "private"

}

resource "aws_s3_bucket_object" "scheduland_code_bucket_object" {
  bucket = aws_s3_bucket.scheduland_code_bucket.id
  key = "beanstalk/scheduland"
  source = "target/scheduland-1.0.0.jar"
}


resource "aws_elastic_beanstalk_environment" "schedulandtfenv" {
  name                = "schedulandtf"
  application         = aws_elastic_beanstalk_application.schedulandtf.name
  solution_stack_name = "64bit Amazon Linux 2 v3.4.1 running Corretto 17"
  
  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "IamInstanceProfile"
    value     =  "aws-elasticbeanstalk-ec2-role"
  }
}