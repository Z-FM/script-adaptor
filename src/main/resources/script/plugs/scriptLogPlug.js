var COM = {
    LOGGER: {
        info: function () {
            switch (arguments.length) {
                case 1:
                    return common_log.info(arguments[0]);
                default:
                    return common_log.info(arguments[0], arguments[1]);
            }
        },
        debug: function () {
            switch (arguments.length) {
                case 1:
                    return common_log.debug(arguments[0]);
                default:
                    return common_log.debug(arguments[0], arguments[1]);
            }
        },
        warn: function () {
            switch (arguments.length) {
                case 1:
                    return common_log.warn(arguments[0]);
                default:
                    return common_log.warn(arguments[0], arguments[1]);
            }
        },
        error: function () {
            switch (arguments.length) {
                case 1:
                    return common_log.error(arguments[0]);
                default:
                    return common_log.error(arguments[0], arguments[1]);
            }
        }
    }
}