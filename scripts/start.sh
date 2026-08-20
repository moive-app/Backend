#!/bin/bash
set -e

CONTAINER_NAME="app7-be"
ENV_FILE="/home/ec2-user/app/.env"
IMAGE_ENV="/home/ec2-user/app/scripts/image.env"

source $IMAGE_ENV

echo "Logging in to ECR..."
aws ecr get-login-password --region ap-northeast-2 \
  | docker login --username AWS --password-stdin $(echo $IMAGE_URI | cut -d'/' -f1)

echo "Pulling image: $IMAGE_URI"
docker pull $IMAGE_URI

echo "Starting container: $CONTAINER_NAME"
docker run -d \
  --name $CONTAINER_NAME \
  -p 8080:8080 \
  --env-file $ENV_FILE \
  --restart unless-stopped \
  $IMAGE_URI

echo "Container started successfully."