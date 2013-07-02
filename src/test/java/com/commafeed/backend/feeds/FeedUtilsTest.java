package com.commafeed.backend.feeds;

import org.junit.Assert;
import org.junit.Test;

public class FeedUtilsTest {

	@Test
	public void testNormalization() {
		String urla1 = "http://example.com/hello?a=1&b=2";
		String urla2 = "http://EXAmPLe.com/HELLo?a=1&b=2";
		String urla3 = "http://example.com/hello?b=2&a=1";
		String urla4 = "https://example.com/hello?a=1&b=2";

		String urlb1 = "http://ftr.fivefilters.org/makefulltextfeed.php?url=http%3A%2F%2Ffeeds.howtogeek.com%2FHowToGeek&max=10&summary=1";
		String urlb2 = "http://ftr.fivefilters.org/makefulltextfeed.php?url=http://feeds.howtogeek.com/HowToGeek&max=10&summary=1";
		
		String urlc1 = "http://feeds.feedburner.com/Frandroid";
		String urlc2 = "http://feeds2.feedburner.com/frandroid";

		Assert.assertEquals(FeedUtils.normalizeURL(urla1), FeedUtils.normalizeURL(urla2));
		Assert.assertEquals(FeedUtils.normalizeURL(urla1), FeedUtils.normalizeURL(urla3));
		Assert.assertEquals(FeedUtils.normalizeURL(urla1), FeedUtils.normalizeURL(urla4));

		Assert.assertEquals(FeedUtils.normalizeURL(urlb1), FeedUtils.normalizeURL(urlb2));
		
		Assert.assertEquals(FeedUtils.normalizeURL(urlc1), FeedUtils.normalizeURL(urlc2));

	}
}

