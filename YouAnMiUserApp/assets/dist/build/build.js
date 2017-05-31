({
    appDir: '../',//项目根目录
    baseUrl: './js',//相对于appDir，代表要查找js文件的起始文件夹，下文所有文件路径的定义都是基于这个baseUrl的
    dir: './dist',//输出目录，全部文件打包后要放入的文件夹（如果没有会自动新建的）
    modules: [//要优化的模块，说白了就是各页面的入口文件，相对baseUrl的路径，也是省略后缀“.js”
        {
            name : 'index',
        },
        {
            name : 'discovery',
        },
        {
            name : 'moreFunction'
        }
    ],
    fileExclusionRegExp: /^(r|build)\.js$/,//过滤，匹配到的文件将不会被输出到输出目录去
    optimizeCss: 'standard',//自动优化应用程序下的css文件（标准的压缩方式）
    removeCombined: true,//如果为true，将从输出目录中删除已合并的文件
    paths : {//相对baseUrl的路径
        "jquery" : "../common/js/lib/zepto.min",
        "frozen" : "../common/js/lib/frozen",
        "underscore":"../common/js/lib/underscore-min",
        "backbone":"../common/js/lib/backbone-min",
        "ToProgress":"../common/js/lib/ToProgress.min",
        "dropload":"../common/js/lib/dropload.min",
        "deferred" : "../common/js/lib/deferred",
        "swiper":"../common/js/lib/swiper-3.3.1.jquery.min"
    },
    shim:{//其实JQ和avalon都不是严格AMD模式，能shim一下最好了，不过这里咱省略
        "jquery":{
            exports: '$'
        },
        "frozen":{
            exports: ''
        },
        "underscore":{
            exports: '_'
        },
        "backbone":{
            deps:['underscore','jquery'],
            exports : 'Backbone'
        },
        "ToProgress":{
            exports:"ToProgress"
        },
        "dropload":{
            exports:"dropload"
        },
        "deferred":{
            exports:"deferred"
        },
        "swiper":{
            exports:"swiper"
        }
    }
})

/**
 * css合并压缩
 *node r.js -o cssIn=css/main.css out=css/built.css optimizeCss=standard
 * js压缩合并（打开node.js程序后，只需要输入以下命令就可以进行压缩）
 * node r.js -o build.js
 */
