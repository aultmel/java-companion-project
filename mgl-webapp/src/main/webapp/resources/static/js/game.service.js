'use strict';

angular.module('GameApp').service('GameService', ['$http', '$log', function($http, $log) {

		var REST_SERVICE_URI = 'game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			deleteGame : deleteGame,
			updateGame : updateGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI).then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI, game).then(function(response) {
					return response.data;
				}
			);
		}
		
		function deleteGame(gameId) {
			return $http.delete(REST_SERVICE_URI + gameId).then(function(response) {
					if (response.data) {
						$log.info("Successfully deleted game with id: " + gameId);
					}
					else {
						$log.debug("No game deleted with id: " + gameId);
					}
					return response.data;
				}
			);
		}
		
		function updateGame(game) {
			return $http.put(REST_SERVICE_URI, game).then(function(response) {
					return response.data;
				}
			);
		}

}]);
