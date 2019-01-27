module.exports = {
    // proxy all webpack dev-server requests starting with /api
    // to our Spring Boot backend (localhost:8088) using http-proxy-middleware
    // see https://cli.vuejs.org/config/#devserver-proxy
    devServer: {
        proxy: {
            '/api': {
                target: 'http://185.174.130.123:8079/api/cashMachines',
                ws: true,
                changeOrigin: true
            }
        }
    }
}
