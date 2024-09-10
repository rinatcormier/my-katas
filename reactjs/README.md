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

## 4. Install HtmlWebpackPlugin
1. `npm install html-webpack-plugin --save-dev`
2. Add *index.html* to **src** dir
3. Update *webpack.config.js*

## 5. Add production mode
1. `npm install webpack-merge --save-dev`
2. Add *webpack.production.js* file
3. Update npm script

## 6. Add development mode
1. `npm i webpack-dev-server --save-dev`
2. Add *webpack.development.js* file
3. Update npm script

## 7. Install typescript
1. `npm i fork-ts-checker-webpack-plugin --save-dev`
2. Update *webpack.config.js*
3. Add *tsconfig.json* file

## 8. Install CSS modules
1. `npm i style-loader css-loader postcss postcss-loader postcss-preset-env mini-css-extract-plugin --save-dev`
2. Add configs
