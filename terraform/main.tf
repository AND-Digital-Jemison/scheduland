resource "aws_elastic_beanstalk_application" "schedulandtf" {
  name = "scheduland"
  description = "Scheduling App"
}

resource "aws_s3_bucket" "scheduland_code" {
  value = '/../build'
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