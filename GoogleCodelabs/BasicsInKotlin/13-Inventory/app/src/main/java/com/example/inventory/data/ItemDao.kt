package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun inset(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM item WHERE id = :id")
    fun getItem(id: Int): Flow<Item> // Funções que retornam Flow não precisam ser suspensas pois são executadas em segundo plano (não precisa executar em corrotina)

    @Query("SELECT * FROM item ORDER BY name")
    fun getItems(): Flow<List<Item>>

}