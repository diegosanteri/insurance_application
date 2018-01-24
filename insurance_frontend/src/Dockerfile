FROM node:alpine

ENV NODE_ENV=production

# Create app directory
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

RUN apk update && apk add git

# Install app dependencies
COPY package.json /usr/src/app/
RUN npm install

# Bundle app source
COPY . /usr/src/app

RUN npm run production

EXPOSE 8080
CMD [ "npm", "run", "deploy" ]
