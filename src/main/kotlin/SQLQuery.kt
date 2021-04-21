class SQLQuery {

    private var builder: StringBuilder = StringBuilder("")
    private var condition: WhereQuery? = null

    fun Select():  SelectQuery{
        return SelectQuery(this, builder)
    }

    fun Build(): String{
        if (builder.isNullOrEmpty())
            return ""
        return builder.append(";").toString()
    }

    fun Where(condition: (where: WhereQuery) -> WhereQuery): SQLQuery{
        if (this.condition == null) {
            builder.append(" WHERE ")
            this.condition = WhereQuery(this, builder)
        }
        builder.append("(")
        condition(this.condition!!)
        builder.append(")")
        return this
    }
}