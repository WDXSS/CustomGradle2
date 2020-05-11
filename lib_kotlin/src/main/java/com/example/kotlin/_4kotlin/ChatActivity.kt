package com.example.kotlin._4kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin._4kotlin.adater.MsgAdapter
import com.example.kotlin._4kotlin.entity.Msg
import kotlinx.android.synthetic.main.kotlin_4_chat_activity.*

@DevKotlin("通过 聊天UI 学习：RecyclerView 的多布局" +
        "kotlin 的延迟初始化和密封类")
class ChatActivity : AppCompatActivity(), View.OnClickListener {

    private val msgList = ArrayList<Msg>()

    private lateinit var adapter: MsgAdapter  //延迟初始化 关键字 lateinit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_4_chat_activity)

        initMsg()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        if (!::adapter.isInitialized) {
            //  ::adapter.isInitialized  判断 变量 adapter 是否被初始化
            adapter = MsgAdapter(msgList)
        }
        recyclerView.adapter = this.adapter

        send.setOnClickListener(this)

    }

    private fun initMsg() {
        val msg = Msg("hello guy", Msg.TYPE_RECEIVED)
        val msg2 = Msg("Hello. Who is that?", Msg.TYPE_SENT)
        val msg3 = Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED)

        msgList.add(msg)
        msgList.add(msg2)
        msgList.add(msg3)

        msg.printlnMsg()
        msg2.printlnMsg()
        msg3.printlnMsg()
    }

    override fun onClick(v: View?) {
        when (v) {
            send -> {
                val content = inputText.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter.notifyItemInserted(msgList.size - 1) // 当有新消息时，刷新RecyclerView中的显示
                    recyclerView.scrollToPosition(msgList.size - 1)  // 将 RecyclerView定位到最后一行
                    inputText.setText("") // 清空输入框中的内容
                }
            }
        }
    }
}
