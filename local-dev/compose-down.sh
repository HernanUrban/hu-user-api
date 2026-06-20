#!/bin/bash

cd $(dirname "$0")
docker-compose -p hu-user-api down -v --remove-orphans