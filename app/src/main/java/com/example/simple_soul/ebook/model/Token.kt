package com.example.simple_soul.ebook.model

import com.example.simple_soul.ebook.model.models.BaseModel

// 包名
private val PACKAGE_NAME = "com.example.simple_soul.ebook."
// 具体Model
val API_USER_DATA = PACKAGE_NAME + "UserDataModel"


inline fun request(token: String): BaseModel<*>?
{
    // 声明一个空的BaseModel
    var model: BaseModel<*>? = null
    try
    {
        //利用反射机制获得对应Model对象的引用
        model = Class.forName(token).newInstance() as BaseModel<*>
    } catch (e: ClassNotFoundException)
    {
        e.printStackTrace()
    } catch (e: InstantiationException)
    {
        e.printStackTrace()
    } catch (e: IllegalAccessException)
    {
        e.printStackTrace()
    }

    return model
}