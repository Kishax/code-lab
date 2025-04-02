const webpack = require('webpack');
const path = require('path');
const fs = require("fs");

const BUILD_ROOT = path.join(__dirname, './dist');
const SRC_ROOT = path.join(__dirname, './src');
const MAIN_SRC = path.join(__dirname, './src/main');

module.exports = (env, argv) => {
  const isProduction = argv.mode === 'production';

  return {
    context: SRC_ROOT,
    entry: path.resolve(SRC_ROOT, 'app.ts'),
    output: {
      filename: 'bundle.js',
      path: BUILD_ROOT,
    },
    module: {
      rules: [
        {
          test: /\.ts$/,
          exclude: /node_modules/,
          use: [
            {
              loader: 'babel-loader',
              options: {
                presets: ['@babel/preset-env'],
              },
            },
            {
              loader: 'ts-loader',
              options: {
                configFile: 'tsconfig.json',
              },
            },
          ],
        }
      ]
    },
    resolve: {
      extensions: ['.ts', '.js', '.json'],
      alias: {
        '@': SRC_ROOT
      }
    },
    mode: isProduction ? 'production' : 'development',
    devtool: isProduction ? undefined : 'inline-source-map',
    devServer: isProduction ? undefined : {
      static: {
        // directory: path.join(__dirname, 'src/main'),
        directory: path.join(__dirname, 'dist'), // contentBase を static.directory に変更
      },
      host: '0.0.0.0',
      port: 8081,
      open: true,
    },
    // if you want to copy not only dist directory but other directory you choice, you could uncomment below
    plugins: [
      {
        apply: (compiler) => {
          compiler.hooks.afterEmit.tapAsync(
            'CopyMainToDistPlugin',
            (compilation, callback) => {
              // const COPY_AT = path.join(__dirname, './path/to/dir');
              // const sourcePath = path.join(BUILD_ROOT, 'client.js');
              // const destPath = path.join(COPT_AT, "client.js");
              // fs.copyFileSync(sourcePath, destPath);
              // fs.copyFile(sourcePath, destPath, (err) => {
              //   if (err) throw err;
              //   console.log('File was copied to destination');
              // });

              fs.readdir(MAIN_SRC, (err, files) => {
                if (err) {
                  return callback(err);
                }

                files.forEach((file) => {
                  const sourcePath = path.join(MAIN_SRC, file);
                  const destPath = path.join(BUILD_ROOT, file);

                  fs.copyFile(sourcePath, destPath, (err) => {
                    if (err) {
                      console.error(`Failed to copy ${file}: ${err}`);
                    } else {
                      console.log(`Copied ${file} to dist`);
                    }
                  });
                });

                callback();
              });
            }
          );
        },
      },
    ],
  };
};
