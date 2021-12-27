package kr.co.mbest.navernewsxml

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kr.co.mbest.navernewsxml.data.Item

class MainNewsRecyclerAdapter(
    val mContext: Context,
    val mList: List<Item>
) :
    RecyclerView.Adapter<MainNewsRecyclerAdapter.ItemViewHolder>() {

    class ItemViewHolder(val mContext: Context, view: View) : RecyclerView.ViewHolder(view) {

        val tv_title = view.findViewById<TextView>(R.id.tv_title)
        val tv_content = view.findViewById<TextView>(R.id.tv_content)
        val layout_news = view.findViewById<LinearLayout>(R.id.layout_news_link)

        fun bind(context: Context, data: Item) {
            tv_title.text = data.title
            tv_content.text = data.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_news_list, parent, false)
        return ItemViewHolder(mContext, view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = mList[position]
        holder.bind(mContext, data)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}