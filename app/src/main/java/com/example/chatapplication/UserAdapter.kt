package com.example.chatapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class UserAdapter(
    private val context: MainActivity,
    private val userList: ArrayList<User>
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    // ViewHolder class for holding views
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView? = itemView.findViewById(R.id.edt_name)

        init {
            if (textView == null) {
                Log.e("ViewHolder", "TextView is null. Check the ID and layout file.")
            }
        }
    }

    // Inflates the layout for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_layout, parent, false)
        return ViewHolder(view)
    }

    // Returns the total number of items
    override fun getItemCount(): Int {
        return userList.size
    }

    // Binds data to the views
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentUser = userList[position]

        holder.textView?.text = currentUser.name ?: "No Name Provided"

        holder.itemView.setOnClickListener{
            val intent = Intent(context,ChatActivity::class.java)

            intent.putExtra("name",currentUser.name)
            intent.putExtra("uid", currentUser.uid)
            context.startActivity(intent)
        }
    }
}
