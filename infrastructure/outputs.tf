output "application_image" {
  description = "Docker image created for the Fibonacci application"
  value       = docker_image.fibonacci_image.name
}

output "application_container" {
  description = "Docker container created by Terraform"
  value       = docker_container.fibonacci_container.name
}

output "container_id" {
  description = "ID of the Fibonacci Docker container"
  value       = docker_container.fibonacci_container.id
}

output "docker_network" {
  description = "Docker network created for the application"
  value       = docker_network.fibonacci_network.name
}