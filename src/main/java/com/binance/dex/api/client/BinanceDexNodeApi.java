package com.binance.dex.api.client;

import com.binance.dex.api.client.domain.BlockMeta;
import com.binance.dex.api.client.domain.jsonrpc.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BinanceDexNodeApi {

    @GET("/abci_query?path=%22/store/acc/key%22")
    Call<JsonRpcResponse<AccountResult>> getAccount(@Query("data") String address);

    @GET("/tx_search")
    Call<JsonRpcResponse<BlockInfoResult>> getBlockTransactions(@Query("query") String height);

    @GET("/broadcast_tx_commit")
    Call<JsonRpcResponse<CommitBroadcastResult>> commitBroadcast(@Query("tx") String tx);

    @GET("/broadcast_tx_sync")
    Call<JsonRpcResponse<AsyncBroadcastResult>> asyncBroadcast(@Query("tx") String tx);

    @GET("/status")
    Call<JsonRpcResponse<NodeInfos>> getNodeStatus();

    @GET("/tx")
    Call<JsonRpcResponse<TransactionResult>> getTransaction(@Query("hash") String hash);

    @GET("/block")
    Call<JsonRpcResponse<BlockMeta.BlockMetaResult>> getBlock(@Query("height") Long height);

    @GET("/block_by_hash")
    Call<JsonRpcResponse<BlockMeta.BlockMetaResult>> getBlock(@Query("hash") String hash);

}
