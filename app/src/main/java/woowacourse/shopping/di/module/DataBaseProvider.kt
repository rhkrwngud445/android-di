package woowacourse.shopping.di.module

import android.content.Context
import androidx.room.Room
import com.app.covi_di.module.Provider
import woowacourse.shopping.data.CartProductDao
import woowacourse.shopping.data.ShoppingDatabase
import kotlin.reflect.KClass

object DataBaseProvider : Provider {
    private lateinit var database: ShoppingDatabase

    override fun init(context: Context) {
        database = initDataBase(context)
    }

    private fun initDataBase(context: Context): ShoppingDatabase {
        return Room.databaseBuilder(
            context,
            ShoppingDatabase::class.java,
            "shopping-db"
        ).build()
    }

    override fun get(): Map<KClass<*>, Any> {
        return mapOf(CartProductDao::class to database.cartProductDao())
    }
}