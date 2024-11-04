package com.fisi.vetmobile.ui.viewmodel

class LoginViewModel : ViewModel() {
    // Login UI state
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()
    var email: String by mutableStateOf("")
    var contrasena: String by mutableStateOf("")

    var loginUIConexion: ConexionUIState by mutableStateOf(ConexionUIState.Loading)
        private set

    fun validarLogin(email: String, contrasena: String) {
        val loginrequest = LoginRequest(email, contrasena)
        viewModelScope.launch {
            try {
                val listResult = SysVitaApi.retrofitService.verificarLogin(loginrequest)
                if (listResult.status == 1) {
                    _uiState.update { currentState ->
                        currentState.copy(isLoginSuccesfull = true)
                    }
                    loginUIConexion = ConexionUIState.Success
                }
            } catch (e: IOException) {
                loginUIConexion = ConexionUIState.Error
            }
        }
    }
}