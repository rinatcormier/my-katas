const { merge } = require("webpack-merge");
const config = require('./webpack.config')
module.exports = merge(config, {
    // Установка режима сборки для использования встроенных в webpack оптимизаций результирующего bundle.
    // https://webpack.js.org/configuration/mode/
    mode: 'production',
});
