package com.development.unique_snakegame.ui.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/development/unique_snakegame/ui/viewmodels/GameViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_gameStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/development/unique_snakegame/ui/states/GameState;", "gameStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getGameStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "job", "Lkotlinx/coroutines/Job;", "changeDirection", "", "direction", "Lcom/development/unique_snakegame/ui/entities/Direction;", "play", "resetGame", "app_debug"})
public final class GameViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.flow.MutableStateFlow<com.development.unique_snakegame.ui.states.GameState> _gameStateFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.development.unique_snakegame.ui.states.GameState> gameStateFlow = null;
    private kotlinx.coroutines.Job job;
    
    public GameViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.development.unique_snakegame.ui.states.GameState> getGameStateFlow() {
        return null;
    }
    
    public final void changeDirection(@org.jetbrains.annotations.NotNull()
    com.development.unique_snakegame.ui.entities.Direction direction) {
    }
    
    public final void play() {
    }
    
    public final void resetGame() {
    }
}