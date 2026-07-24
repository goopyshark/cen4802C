variable "application_name" {
  description = "Name assigned to the Fibonacci Docker resources"
  type        = string
  default     = "fibonacci-iac"
}

variable "image_name" {
  description = "Name and tag of the Fibonacci Docker image"
  type        = string
  default     = "fibonacciapp:iac"
}

variable "container_name" {
  description = "Name assigned to the Fibonacci application container"
  type        = string
  default     = "fibonacci-terraform"
}

variable "network_name" {
  description = "Name assigned to the Docker network"
  type        = string
  default     = "fibonacci-network"
}