# BASE IMAGE with an alias #
# FROM nginx:1.25-alpine
# COPY /dist/home /usr/share/nginx/html

# docker build -t home-angular .
# docker run -p 80:80 home-angular

# stage 1
FROM node:latest as builder
WORKDIR /usr/local/app
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build
# stage 2
FROM nginx:1.25-alpine as home-angular
COPY --from=builder /app/dist/home /usr/share/nginx/html
EXPOSE 80
#clear && docker build -t home-angular . && docker run -p 80:80 home-angular