
class SelectQuery (val query: SQLQuery, val builder: StringBuilder) {

    init {
        builder.append("SELECT ")
    }

    fun All(): SelectQuery{
        builder.append("* ")
        return this
    }

    fun Count(){
    }

    fun Count(columnName: String){
    }

    fun From(tableName: String): SQLQuery{
        builder.append("FROM ").append(tableName)
        return this.query
    }


}