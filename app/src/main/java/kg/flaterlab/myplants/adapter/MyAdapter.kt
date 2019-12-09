package kg.flaterlab.myplants.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kg.flaterlab.myplants.R
import kg.flaterlab.myplants.activity.PlantActivity
import kg.flaterlab.myplants.model.Plant
import kotlinx.android.synthetic.main.my_adapter_item.view.*

class MyAdapter(private val myDataset: Array<Plant>, private val context :AppCompatActivity) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val linearLayout: LinearLayout) : RecyclerView.ViewHolder(linearLayout)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.MyViewHolder {
        val linearLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_adapter_item, parent, false) as LinearLayout
        return MyViewHolder(linearLayout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val p :Plant =  myDataset[position]
        holder.linearLayout.elevation = 8.0f
        holder.linearLayout.textView.text = p.name
        holder.linearLayout.setOnClickListener{
            val intent = Intent(context, PlantActivity::class.java)
            intent.putExtra("id", p.name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = myDataset.size
}