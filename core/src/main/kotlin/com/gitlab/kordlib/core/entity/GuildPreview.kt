package com.gitlab.kordlib.core.entity

import com.gitlab.kordlib.common.entity.GuildFeature
import com.gitlab.kordlib.common.entity.Snowflake
import com.gitlab.kordlib.core.Kord
import com.gitlab.kordlib.core.cache.data.GuildPreviewData
import com.gitlab.kordlib.core.supplier.EntitySupplier

class GuildPreview(
        val data: GuildPreviewData,
        override val kord: Kord
) : Entity {

    override val id: Snowflake
        get() = Snowflake(data.id)

    /**
     * The name of the guild
     */
    val name: String get() = data.name

    /**
     * Icon hash.
     */
    val icon: String? get() = data.icon

    /**
     * Splash hash.
     */
    val splash: String? get() = data.splash

    /**
     * Discovery splash hash.
     */
    val discoverySplash: String? get() = data.discoverySplash

    /**
     * Ids of custom guild emojis.
     */
    val emojis: Set<GuildEmoji> get() = data.emojis.map { GuildEmoji(it, kord) }.toSet()

    /**
     * Enabled guild features.
     */
    val features: Set<GuildFeature> get() = data.features.toSet()

    /**
     * Approximate number of members in this guild.
     */
    val approximateMemberCount: Int get() =  data.approximateMemberCount

    /**
     * Approximate number of online members in this guild.
     */
    val approximatePresenceCount: Int get() = data.approximatePresenceCount

    /**
     * The description for the guild.
     */
    val description: String? get() = data.description

}
