package com.chute.android.cloudgallerytutorial;

import com.chute.android.gallery.components.GalleryViewFlipper;
import com.chute.sdk.api.GCHttpCallback;
import com.chute.sdk.api.chute.GCChutes;
import com.chute.sdk.collections.GCAssetCollection;
import com.chute.sdk.model.GCHttpRequestParameters;

import android.app.Activity;
import android.os.Bundle;

public class GalleryActivity extends Activity {

	public static final String TAG = GalleryActivity.class.getSimpleName();
	private static final String CHUTE_ID = "1946";
	private GalleryViewFlipper gallery;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery_activity);

		gallery = (GalleryViewFlipper) findViewById(R.id.galleryId);
		GCChutes.Resources.assets(getApplicationContext(), CHUTE_ID,
				new AssetCollectionCallback()).executeAsync();
	}

	private final class AssetCollectionCallback implements
			GCHttpCallback<GCAssetCollection> {

		@Override
		public void onSuccess(GCAssetCollection responseData) {
			gallery.setAssetCollection(responseData);
		}

		@Override
		public void onHttpException(GCHttpRequestParameters params,
				Throwable exception) {

		}

		@Override
		public void onHttpError(int responseCode, String statusMessage) {
		}

		@Override
		public void onParserException(int responseCode, Throwable exception) {
		}

	}
}
