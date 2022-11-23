/*
 * This file is/was part of Treasury. To read more information about Treasury such as its licensing, see <https://github.com/ArcanePlugins/Treasury>.
 */

package me.lokka30.treasury.api.permission.node;

import me.lokka30.treasury.api.common.misc.TriState;
import me.lokka30.treasury.api.permission.context.Context;
import me.lokka30.treasury.api.permission.context.ContextType;
import me.lokka30.treasury.api.permission.node.type.PermissionNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class NodeFactory {

    @NotNull
    public PermissionNode createPermissionNode(@NotNull String permission) {
        return this.createPermissionNode(permission, ContextType.global());
    }

    public PermissionNode createPermissionNode(
            @NotNull String permission, @NotNull Context context
    ) {
        return this.createPermissionNode(permission, context, null);
    }

    @NotNull
    public PermissionNode createPermissionNode(
            @NotNull String permission, @NotNull Context context, @Nullable Integer weight
    ) {
        return this.createPermissionNode(permission, context, TriState.UNSPECIFIED, weight);
    }

    @NotNull
    public abstract PermissionNode createPermissionNode(
            @NotNull String permission,
            @NotNull Context context,
            @NotNull TriState value,
            @Nullable Integer weight
    );

}
