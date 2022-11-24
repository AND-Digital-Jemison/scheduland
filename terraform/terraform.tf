terraform {
  backend "s3" {
     bucket = "scheduland-tf"
     key    = "state.tf"
     region = "eu-west-2"
  }
  # required_providers {
  #   aws = {
  #     source = "hashicorp/aws"
  #   }
  # }
}