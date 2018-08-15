package com.example.simple_soul.ebook.model.models

import com.example.simple_soul.ebook.model.beans.PreviewInfo

class SearchModel: BaseModel<PreviewInfo>()
{


    fun getAdapterData(): List<PreviewInfo>
    {
        var data = mutableListOf<PreviewInfo>()
        TODO()
    }
}