#!/bin/bash

cd $(dirname "$0")
docker-compose -p hu-user-api up -d --build --remove-orphans