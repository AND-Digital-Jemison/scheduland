terraform {
  backend "s3" {
     bucket = "scheduland-state"
     key    = "state.tf"
     region = "eu-west-2"
  }
  # required_providers {
  #   aws = {
  #     source = "hashicorp/aws"
  #   }
  # }
}