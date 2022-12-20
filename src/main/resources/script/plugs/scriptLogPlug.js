var COM = {
    Database: {
        table(tableName) {
            let DatabaseClass = Java.ype("com.zfm.scriptadaptor.domain.script.plugs.DatabasePlug");
            let database = new DatabaseClass(tableName);
            function selectById() {
                return database.selectById(arguments[0]);
            }

        }
    }
}