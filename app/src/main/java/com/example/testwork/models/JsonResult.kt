package com.example.testwork.models

data class JsonResult(
    val actor: Actor,
    val created_at: String,
    val id: String,
    val org: Org,
    val payload: Payload,
    val `public`: Boolean,
    val repo: Repo,
    val type: String
)

data class Actor(
    val avatar_url: String,
    val display_login: String,
    val gravatar_id: String,
    val id: Int,
    val login: String,
    val url: String
)

data class Org(
    val avatar_url: String,
    val gravatar_id: String,
    val id: Int,
    val login: String,
    val url: String
)

data class Payload(
    val before: String,
    val commits: List<Commit>,
    val distinct_size: Int,
    val head: String,
    val push_id: Long,
    val ref: String,
    val size: Int
)

data class Repo(
    val id: Int,
    val name: String,
    val url: String
)

data class Commit(
    val author: Author,
    val distinct: Boolean,
    val message: String,
    val sha: String,
    val url: String
)

data class Author(
    val email: String,
    val name: String
)