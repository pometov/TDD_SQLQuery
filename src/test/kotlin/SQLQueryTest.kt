import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SQLQueryTest {

    @Test
    fun build() {
        assertEquals("", SQLQuery().Build())
    }

    @Test
    fun selectAll() {
        assertEquals("SELECT * FROM TABLE;", SQLQuery().Select().All().From("TABLE").Build())
    }

    @Test
    fun where() {
        assertEquals("SELECT * FROM TABLE WHERE (NAME='IVAN' AND AGE>17);", SQLQuery().Select().All()
            .From("TABLE").Where { c -> c.Condition("NAME", "=","IVAN")
                .And("AGE", ">", 17) }.Build())
    }
}