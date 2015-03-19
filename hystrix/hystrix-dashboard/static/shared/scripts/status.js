/*
 * Copyright 2013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

var statusModule = angular.module('status', []);

statusModule.factory('Status', function () {
    var status = null;

    var success = function (message) {
        this.status = {
            isError: false,
            message: message,
            details: null
        };
    };

    var error = function (message) {
        this.status = {
            isError: true,
            message: message,
            details: null
        };
    };

    var errorWithDetails = function (message, error) {
        this.status = {
            isError: true,
            message: message,
            details: {description: error.data.description, statusCode: error.status, statusText: error.statusText}
        };
    };

    var clear = function () {
        this.status = null;
    };

    return {
        status: status,
        success: success,
        error: error,
        errorWithDetails: errorWithDetails,
        clear: clear
    }
});

statusModule.controller('StatusController', function ($scope, Status) {
    $scope.$watch(
        function () {
            return Status.status;
        },
        function (status) {
            $scope.status = status;
        },
        true);

    $scope.clearStatus = function () {
        Status.clear();
    };
});