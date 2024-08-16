package com.github.l1an.yuvarielevel.api.event

import org.bukkit.entity.Player
import taboolib.platform.type.BukkitProxyEvent

class PlaceholderHookEvent(
    val player: Player,
    val identifier: String,
    val parameter: String,
    var result: Any? = null
) : BukkitProxyEvent()