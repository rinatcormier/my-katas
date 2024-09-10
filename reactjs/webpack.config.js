const {resolve} = require("path");
module.exports = {
    // Входящая точка в приложение
    // https://webpack.js.org/configuration/entry-context/#entry
    entry: './main.js',
    // Определяет контекст сборки, основную директорию, абсолютный путь для входящей точки (entry)
    // https://webpack.js.org/configuration/entry-context/#context
    context: resolve(__dirname, 'src'),
    // Определяет директорию в которую помещаются файлы сборки
    output: {
        // путь до директории с файлами сборки
        // https://webpack.js.org/configuration/output/#outputpath
        path: resolve(__dirname, 'build'),
        // очищать директорию от предыдущих сборок
        // https://webpack.js.org/configuration/output/#outputclean
        clean: true,
        // https://webpack.js.org/configuration/output/#outputfilename
        filename: "[name].[contenthash].js"
    }
}
