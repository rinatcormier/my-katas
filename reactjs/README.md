# Init ReactJS App Step-By-Step Guide

## 1. Init project
1. Init *package.json* file [docs](https://docs.npmjs.com/cli/v10/commands/npm-init/), `npm init -y`
2. Add **node_modules** and **build** directories to *.gitignore*

## 2. Install webpack
1. `npm install webpack webpack-cli --save-dev`
2. Create file *webpack.config.js*
3. Add npm command: `"build": "webpack"`

## 3. Install Babel
1. `npm install babel-loader @babel/core @babel/preset-env @babel/preset-react @babel/preset-typescript --save-dev`
2. Create *.babelrc* file in the root of the project
3. Change extension of entry point (*main.js* -> *main.ts*)
4. Update *webpack.config.js*
