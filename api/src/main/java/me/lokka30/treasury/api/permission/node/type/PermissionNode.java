/*
 * This file is/was part of Treasury. To read more information about Treasury such as its licensing, see <https://github.com/ArcanePlugins/Treasury>.
 */

package me.lokka30.treasury.api.permission.node.type;

import me.lokka30.treasury.api.common.misc.TriState;
import me.lokka30.treasury.api.permission.node.Node;
import me.lokka30.treasury.api.permission.node.type.NodeType;
import org.jetbrains.annotations.NotNull;

public interface PermissionNode extends Node<TriState> {

    @Override
    @NotNull
    default NodeType<TriState> nodeType() {
        return NodeType.PERMISSION;
    }

}