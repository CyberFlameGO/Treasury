/*
 * This file is/was part of Treasury. To read more information about Treasury such as its licensing, see <https://github.com/ArcanePlugins/Treasury>.
 */

package me.lokka30.treasury.api.permission.events;

import me.lokka30.treasury.api.permission.node.holder.NodeHolder;
import org.jetbrains.annotations.NotNull;

public class NodeRemoveEvent extends NodeEvent {

    private final NodeHolder nodeHolder;

    public NodeRemoveEvent(
            @NotNull NodeHolder nodeHolder, @NotNull NodeEvent.Result initialResult
    ) {
        super(initialResult);
        this.nodeHolder = nodeHolder;
    }

    @NotNull
    public NodeHolder getNodeHolder() {
        return this.nodeHolder;
    }

}
