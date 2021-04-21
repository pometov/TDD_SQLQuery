
class WhereQuery (val query: SQLQuery, val builder: StringBuilder) {


    private fun Condition(columnName: String, symbol: String): StringBuilder{
        return builder.append(columnName).append(symbol)
    }

    fun Condition(columnName: String, symbol: String, searchName: String): WhereQuery{
        Condition(columnName, symbol).append("'").append(searchName).append("'")
        return this
    }

    fun Condition(columnName: String, symbol: String, searchName: Int): WhereQuery{
        Condition(columnName, symbol).append(searchName)
        return this
    }

    fun And(columnName: String, symbol: String, searchName: String): WhereQuery{
        builder.append(" AND ")
        return Condition(columnName, symbol, searchName)
    }

    fun And(columnName: String, symbol: String, searchName: Int): WhereQuery{
        builder.append(" AND ")
        return Condition(columnName, symbol, searchName)
    }

    fun Or(columnName: String, symbol: String, searchName: String): WhereQuery{
        builder.append(" OR ")
        return Condition(columnName, symbol, searchName)
    }
    fun Or(columnName: String, symbol: String, searchName: Int): WhereQuery{
        builder.append(" OR ")
        return Condition(columnName, symbol, searchName)
    }
}