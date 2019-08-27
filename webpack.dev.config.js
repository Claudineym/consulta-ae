onst webpack = require('webpack');
const autoprefixer = require('autoprefixer');
const merge = require('webpack-merge');
const path = require('path');
const ProgressBarPlugin = require('progress-bar-webpack-plugin');
const common = require('./webpack.common.js');
const ROOT_DIR = path.resolve(__dirname, '../');
const DIST_DIR = path.resolve(ROOT_DIR, 'dist');
module.exports = merge(common, {
  mode: 'development', //
  devtool: 'eval',
  entry: [
	  entry: ['babel-polyfill', './src/main/webapp/app/index.jsx'],
  ],
  output: {
	path: path.resolve(__dirname , '/src/main/webapp/resources/js'),
    filename: 'bundle.js',
  },

  plugins: [
    new ProgressBarPlugin({
      format: 'Build [:bar] :percent (:elapsed seconds)',
      clear: false,
    }),
    new webpack.NamedModulesPlugin(),
    new webpack.HotModuleReplacementPlugin(),
  ]
});