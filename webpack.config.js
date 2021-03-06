const path = require('path');
const webpack = require('webpack');
const ROOT_DIR = path.resolve(__dirname, '../');
const SRC_DIR = path.resolve(ROOT_DIR, 'src');
const HtmlWebpackPlugin = require('html-webpack-plugin');
module.exports = {
  entry: [
    'babel-polyfill',
    './src/main/webapp/app/index.jsx',
  ],
  output: {
	path: path.resolve(__dirname , './src/main/webapp/resources/js'),
	filename: 'bundle.js',
  },
  resolve: {
    modules: [
      'src',
      'node_modules',
      'theme',
      'theme/fonts',
    ],
    extensions: ['.js', '.css', '.scss', '.tsx', '.jsx'],
    alias: {
      theme: path.resolve(ROOT_DIR, 'theme'),
    },
  },
  module: {
    rules: [
      // js
      {
    	test: /\.jsx$|\.tsx$|\js$/,        
        exclude: /(node_modules|bower_components)/,   
        use: {
        	loader: 'babel-loader',
        	options: {
                presets: ['@babel/preset-react', '@babel/preset-env'],
                plugins: [
                    [
                      "@babel/plugin-proposal-class-properties"
                    ]
                ]
            }
        }
      },
      // css
      { test: /\.css$/, loader: "style-loader!css-loader" },
      // images
      {
        test: /\.(png|ico|gif|svg|jpe?g)(\?[a-z0-9]+)?$/,
        use: 'url-loader',
      },
      // fonts
      { test: /\.(woff|woff2|eot|ttf|otf)$/, use: ['url-loader'] }
    ]
  },
  plugins: [
	    
	    new HtmlWebpackPlugin({
	      
	    })
	  ],
 /* plugins: [
    new webpack.DefinePlugin({
      'process.env': {
        NODE_ENV: JSON.stringify(process.env.NODE_ENV),
        CUSTOM_HOST: JSON.stringify(process.env.CUSTOM_HOST),
        HTTPS: JSON.stringify(process.env.HTTPS),
        RUBY_BACKEND: JSON.stringify(process.env.RUBY_BACKEND),
      }
    }),
  ]*/
};