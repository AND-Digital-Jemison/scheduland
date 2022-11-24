terraform {
  backend "s3" {
     bucket = "scheduland-prod"
     key    = "scheduland"
     region = "eu-west-2"
  }
  # required_providers {
  #   aws = {
  #     source = "hashicorp/aws"
  #   }
  # }
}