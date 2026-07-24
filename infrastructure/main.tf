# Create a dedicated Docker network for the application.
resource "docker_network" "fibonacci_network" {
  name = var.network_name

  labels {
    label = "application"
    value = var.application_name
  }

  labels {
    label = "managed-by"
    value = "terraform"
  }
}

# Build the Fibonacci Docker image using the Dockerfile
# located in the parent project directory.
resource "docker_image" "fibonacci_image" {
  name         = var.image_name
  keep_locally = false

  build {
    context    = ".."
    dockerfile = "Dockerfile"

    label = {
      application = var.application_name
      managed_by  = "terraform"
    }
  }
}

# Create the Fibonacci application container.
resource "docker_container" "fibonacci_container" {
  name  = var.container_name
  image = docker_image.fibonacci_image.image_id

  networks_advanced {
    name = docker_network.fibonacci_network.name
  }

  labels {
    label = "application"
    value = var.application_name
  }

  labels {
    label = "managed-by"
    value = "terraform"
  }

  depends_on = [
    docker_image.fibonacci_image,
    docker_network.fibonacci_network
  ]
}