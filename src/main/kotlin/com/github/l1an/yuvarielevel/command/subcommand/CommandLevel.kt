package com.github.l1an.yuvarielevel.command.subcommand

import org.bukkit.command.CommandSender
import org.serverct.parrot.parrotx.module.level.LevelManager
import org.serverct.parrot.parrotx.module.level.LevelManager.getLevelOption
import org.serverct.parrot.parrotx.module.level.LevelManager.giveExperience
import org.serverct.parrot.parrotx.module.level.LevelManager.giveLevel
import org.serverct.parrot.parrotx.module.level.LevelManager.setExperience
import org.serverct.parrot.parrotx.module.level.LevelManager.setLevel
import org.serverct.parrot.parrotx.util.toPlayer
import taboolib.common.platform.command.player
import taboolib.common.platform.command.subCommand
import taboolib.common.platform.command.suggest
import taboolib.common5.Coerce

/**
 * level addlevel <player> <levelOption> <value> - 增加等级
 * level setlevel <player> <levelOption> <value> - 设置等级
 * level addexp <player> <levelOption> <value> - 增加经验
 * level setexp <player> <levelOption> <value> - 设置经验
 */
val CommandLevel = subCommand {

    literal("addlevel") {
        player {
            dynamic("level") {
                suggest { LevelManager.level.keys.toList() }
                dynamic("value") {
                    exec<CommandSender> {
                        val option = getLevelOption(ctx["level"])!!
                        val player = ctx.toPlayer()
                        player.giveLevel(option, Coerce.toInteger(ctx["value"]))
                    }
                }
            }
        }
    }

    literal("setlevel") {
        player {
            dynamic("level") {
                suggest { LevelManager.level.keys.toList() }
                dynamic("value") {
                    exec<CommandSender> {
                        val option = getLevelOption(ctx["level"])!!
                        val player = ctx.toPlayer()
                        player.setLevel(option, Coerce.toInteger(ctx["value"]))
                    }
                }
            }
        }
    }

    literal("addexp") {
        player {
            dynamic("level") {
                suggest { LevelManager.level.keys.toList() }
                dynamic("value") {
                    exec<CommandSender> {
                        val option = getLevelOption(ctx["level"])!!
                        val player = ctx.toPlayer()
                        player.giveExperience(option, Coerce.toInteger(ctx["value"]))
                    }
                }
            }
        }
    }

    literal("setexp") {
        player {
            dynamic("level") {
                suggest { LevelManager.level.keys.toList() }
                dynamic("value") {
                    exec<CommandSender> {
                        val option = getLevelOption(ctx["level"])!!
                        val player = ctx.toPlayer()
                        player.setExperience(option, Coerce.toInteger(ctx["value"]))
                    }
                }
            }
        }
    }

}