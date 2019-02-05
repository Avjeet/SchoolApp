package com.daphnis.gurus

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.labs.daphnis.schoolapp.Activity.ActivityMessages
import com.labs.daphnis.schoolapp.R

import com.stfalcon.chatkit.commons.ImageLoader
import com.stfalcon.chatkit.commons.models.IDialog
import com.stfalcon.chatkit.commons.models.IMessage
import com.stfalcon.chatkit.commons.models.IUser
import com.stfalcon.chatkit.commons.models.MessageContentType
import com.stfalcon.chatkit.dialogs.DialogsList
import com.stfalcon.chatkit.dialogs.DialogsListAdapter

import java.util.ArrayList
import java.util.Date




class FragmentPeople : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dialogsList = view.findViewById<DialogsList>(R.id.dialogsList)

        val dialogs = ArrayList<ModelDialog>()

        val dialogsListAdapter = DialogsListAdapter<ModelDialog>(ImageLoader { imageView, url, payload ->
            Glide.with(requireContext()).load(R.drawable.profile_01).into(imageView)
        })

        val users = ArrayList<ModelUser>()
        users.add(ModelUser("1", "Abhishek Gahlawat", ""))
        dialogs.add(
            ModelDialog(
                "1",
                "",
                "Abhishek Gahlawat",
                users,
                Message("1", ModelUser("1", "Abhishek Gahlawat", ""), "Hi there"),
                1
            )
        )
        dialogsListAdapter.setItems(dialogs)
        dialogsListAdapter.setOnDialogClickListener {
            context!!.startActivity(
                Intent(
                    context,
                    ActivityMessages::class.java
                )
            ) }

        dialogsList.setAdapter(dialogsListAdapter)

    }

    inner class ModelDialog(
        private var id: String,
        private var dialogPhoto: String,
        private var dialogName: String,
        private var users: ArrayList<ModelUser>,
        private var lastMessage: IMessage,
        private var unreadCount: Int
    ) : IDialog<IMessage> {

        override fun getId(): String {
            return id
        }

        override fun getDialogPhoto(): String {
            return dialogPhoto
        }

        override fun getDialogName(): String {
            return dialogName
        }

        override fun getUsers(): ArrayList<ModelUser> {
            return users
        }

        override fun getLastMessage(): IMessage {
            return lastMessage
        }

        override fun setLastMessage(lastMessage: IMessage) {
            this.lastMessage = lastMessage
        }

        override fun getUnreadCount(): Int {
            return unreadCount
        }
    }

    class ModelUser(internal var id: String, internal var name: String, internal var avatar: String) : IUser {

        override fun getId(): String {
            return id
        }

        override fun getName(): String {
            return name
        }

        override fun getAvatar(): String {
            return avatar
        }
    }

    class Message @JvmOverloads constructor(
        private val id: String,
        private val user: ModelUser,
        private var text: String?,
        private var createdAt: Date? = Date()
    ) : IMessage, MessageContentType.Image, /*this is for default image messages implementation*/
        MessageContentType /*and this one is for custom content type (in this case - voice message)*/ {
        private var image: Image? = null
        private var voice: Voice? = null

        val status: String
            get() = "Sent"

        override fun getId(): String {
            return id
        }

        override fun getText(): String? {
            return text
        }

        override fun getCreatedAt(): Date? {
            return createdAt
        }

        override fun getUser(): ModelUser {
            return this.user
        }

        override fun getImageUrl(): String? {
            return if (image == null) null else image!!.url
        }

        fun setText(text: String) {
            this.text = text
        }

        fun setCreatedAt(createdAt: Date) {
            this.createdAt = createdAt
        }

        fun setImage(image: Image) {
            this.image = image
        }

        fun setVoice(voice: Voice) {
            this.voice = voice
        }

        class Image(val url: String)

        class Voice(val url: String, val duration: Int)
    }

}
