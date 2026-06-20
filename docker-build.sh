#!/bin/bash

# Detener el script si ocurre algún error
set -e

# Nombre de la imagen
IMAGE_NAME="hu-user-api"

# Leer la versión desde el archivo VERSION
if [ -f "VERSION" ]; then
    VERSION=$(cat VERSION)
else
    echo "WARN! Archivo VERSION no encontrado. Se usa local"
    VERSION="local"
fi

echo "Construyendo imagen $IMAGE_NAME con versión: $VERSION"

# Build de la imagen Docker
# Usa -t para etiquetar con nombre:version
docker build --platform linux/amd64 -t "$IMAGE_NAME:$VERSION" .

# (Opcional) Etiquetar también como 'latest'
docker tag "$IMAGE_NAME:$VERSION" "$IMAGE_NAME:latest"

echo "Imagen $IMAGE_NAME:$VERSION construida exitosamente."
