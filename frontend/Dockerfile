# BASE IMAGE with an alias #
# FROM nginx:1.25-alpine
# COPY /dist/home /usr/share/nginx/html

# docker build -t home-angular .
# docker run -p 80:80 home-angular

# stage 1
FROM node:latest AS builder
WORKDIR /usr/local/app
COPY . /usr/local/app
RUN npm install
RUN npm run build
# stage 2
FROM nginx:1.25-alpine AS home.angular
COPY --from=builder /usr/local/app/dist/frontend /usr/share/nginx/html
EXPOSE 80
#clear && docker build -t home-angular . && docker run -p 80:80 home-angular
#clear && docker build . -t maxgladikov/home.frontend:1.0.0 && docker push  maxgladikov/home.frontend:1.0.0
